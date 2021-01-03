import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.TryValues._
import sisp.Sisp
import sisp.ast.{Expression, NumberElement, Quote}

import scala.util.Success

/**
 * TODO
 *
 * @author mars
 * @version 1.0.0
 * @since 2020/08/05 18:51
 */
class QuoteSpec extends AnyFlatSpec with Matchers {
  val sisp = new Sisp
  "Quote" should "quote anything" in {
    sisp.read("'(+ 2 3)").success.value.isInstanceOf[Quote] shouldBe true

    sisp.parse("'(+ 2 3)").success.value.isInstanceOf[Expression] shouldBe true
    
    (sisp.parse("'(+ 2 3)") flatMap sisp.eval)
      .success.value shouldBe 5.0
    
    sisp.parse("'3.14").success.value shouldBe NumberElement(3.14)

  }
}
