package sisp.parsers

import jaskell.parsec.{Parsec, State}

import scala.util.Try

/**
 * TODO
 *
 * @author mars
 * @version 1.0.0
 * @since 2020/07/22 16:44
 */
class Parser extends Parsec[Char, Any]{
  lazy val expr: Parsec[Char, Any] = (new ExprParser).attempt
  val number: Parsec[Char, Any] = (new NumberParser).attempt
  val string: Parsec[Char, Any] = (new StringParser).attempt
  val quote: Parsec[Char, Any] = (new QuoteParser).attempt
  val name: Parsec[Char, Any] = (new NameParser).attempt
  override def apply(s: State[Char]): Try[Any] = {
    val parser: Parsec[Char, Any] = quote <|> expr <|> number <|> string <|> name
    parser ? s
  }
}
