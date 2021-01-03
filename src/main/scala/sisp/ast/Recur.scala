package sisp.ast

import scala.util.Try

/**
 * TODO
 *
 * @author mars
 * @version 1.0.0
 * @since 2020/08/04 21:07
 */
class Recur extends Lambda {
  import jaskell.seqU
  override def apply(env: Env, params: Seq[Any]): Try[Any] = {
    (params map env.eval).flip map RecurExpression.apply
  }
}

case class RecurExpression(params: Seq[Any])
