package sisp.parsers

import jaskell.parsec.Atom.pack
import jaskell.parsec.Combinator.{between, sepBy1}
import jaskell.parsec.Txt.{ch, skipWhiteSpaces}
import jaskell.parsec.{Parsec, SkipWhitespaces, State}
import sisp.ast.{Element, Expression}

import scala.util.Try

/**
 * TODO
 *
 * @author mars
 * @version 1.0.0
 * @since 2020/07/21 18:21
 */
class ExprParser extends Parsec[Char, Any]{
  import jaskell.parsec.parsecConfig
  val skip: SkipWhitespaces = skipWhiteSpaces
  val elementParser = new Parser
  val left = ch('(') *> skip
  val right = skip *> ch(')')
  
  lazy val parser =
    left *> sepBy1(elementParser, skip) <* right  >>=
      {vals => pack(new Expression(vals))}

  override def apply(s: State[Char]): Try[Element] = parser ? s
}
