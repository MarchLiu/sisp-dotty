package sisp.parsers

import jaskell.parsec.Atom.one
import jaskell.parsec.Combinator.{between, many}
import jaskell.parsec.Txt.{ch, chNone, mkString}
import jaskell.parsec.{ChNone, Parsec, State}
import sisp.ParserException

import scala.util.{Failure, Success, Try}

/**
 * TODO
 *
 * @author mars
 * @version 1.0.0
 * @since 2020/07/24 15:55
 */
class StringParser extends Parsec[Char, Any] {
  import jaskell.parsec.parsecConfig  

  val char: ChNone = chNone("\"\\")
  val escapeChar: Parsec[Char, Char] = (ch('\\') *> {(s: State[Char]) =>
    one ? s flatMap {
      case 'n' => Success('\n')
      case 't' => Success('\t')
      case 'r' => Success('\r')
      case '"' => Success('"')
      case '\\' => Success('\\')
      case c => Failure(new ParserException(s"expect a escape char but get \\$c"))
    }
  }).attempt
  lazy val parser: Parsec[Char, String] = between(ch('"'), ch('"'), many(escapeChar <|> char)) >>= mkString

  override def apply(s: State[Char]): Try[String] = {
    parser ? s
  }
}
