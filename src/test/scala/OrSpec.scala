import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import sisp.ast._
import sisp.parsers.Parser

import scala.util.Success

/**
 * TODO
 *
 * @author mars
 * @version 1.0.0
 * @since 2020/07/30 18:19
 */
class OrSpec extends AnyFlatSpec with Matchers {
  import jaskell.parsec.Txt._
  import jaskell.parsec.stateConfig

  val parser = new Parser
  val env = new Env
  env.put("def", new Def)
  env.put("if", new If)

  env.put("+", new Add)
  env.put("-", new Sub)
  env.put("*", new sisp.ast.Product)
  env.put("/", new Divide)
  env.put("and", new And)
  env.put("or", new Or)
  env.put("true?", new IsTrue)
  env.put("false?", new IsFalse)
  env.put("==", new Eq)
  env.put("!=", new Eq)
  env.put(">", new Great)
  env.put("<", new Less)
  env.put(">=", new GreatOrEquals)
  env.put("<=", new LessOrEquals)

  "XOrY" should "true only (and true true)" in {
    parser ? "(or (> 1 0) (> 2 1))".state flatMap { element =>
      element.asInstanceOf[Element].eval(env)
    } should be (Success(true))

    parser ? "(or (> 1 0) (< 2 1))".state flatMap { element =>
      element.asInstanceOf[Element].eval(env)
    } should be (Success(true))

    parser ? "(or (>= 1 0) (> 2 1))".state flatMap { element =>
      element.asInstanceOf[Element].eval(env)
    } should be (Success(true))

    parser ? "(or (> 0 0) (> 1 1))".state flatMap { element =>
      element.asInstanceOf[Element].eval(env)
    } should be (Success(false))
  }
}
