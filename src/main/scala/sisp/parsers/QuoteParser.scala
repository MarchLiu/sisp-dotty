package sisp.parsers

import jaskell.parsec.{Parsec, State}
import jaskell.parsec.Atom.pack
import jaskell.parsec.Txt.ch
import sisp.ast.Quote

import scala.util.Try

/**
 * TODO
 *
 * @author mars
 * @version 1.0.0
 * @since 2020/08/05 18:42
 */
class QuoteParser extends Parsec[Char, Any]{
  import jaskell.parsec.Txt.{ch}
  import jaskell.parsec.parsecConfig
  lazy val parser = new Parser
  lazy val psc = ch('\'') *> parser >>= {value => pack(new Quote(value))}

  override def apply(s: State[Char]): Try[Any] = psc ? s
}