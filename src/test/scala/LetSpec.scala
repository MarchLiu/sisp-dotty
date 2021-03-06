import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import sisp.ast._
import sisp.parsers.Parser
import org.scalatest.TryValues._
import scala.util.Success

/**
 * TODO
 *
 * @author mars
 * @version 1.0.0
 * @since 2020/08/03 23:32
 */
class LetSpec extends AnyFlatSpec with Matchers {
  import jaskell.parsec.stateConfig

  import jaskell.parsec.Txt._

  val parser = new Parser
  val env = new Env
  env.put("def", new Def)
  env.put("do", new Do)
  env.put("let", new Let)

  env.put("+", new Add)
  env.put("-", new Sub)
  env.put("*", new sisp.ast.Product)
  env.put("/", new Divide)
  
  "Let" should "support local vars" in {
    (parser ? "(let (pi 3.14) (* 2 pi))".state flatMap {exp => env.eval(exp)})
      .success.value shouldBe 6.28
  }
}
