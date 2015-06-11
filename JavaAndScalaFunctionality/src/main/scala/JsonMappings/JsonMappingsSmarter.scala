package JsonMappings
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.specs2.mutable._
import org.specs2.specification._

@JsonInclude(Include.NON_EMPTY)
case class ArtifactOrigin(artifactName: String,
                          artifactSource: String,
                          artifactProperties: Option[Map[String, String]] = None)

case class PlainArtifactsOrigins(artifacts: List[ArtifactOrigin])

class JsonMappingsSmarter extends Specification  with ArtifactTestData {

  trait Context extends Scope  {
    val jsonMapper = {
      val m = new ObjectMapper()
      m.registerModule(DefaultScalaModule)
      m
    }
  }

  "Plain Inventory" should {
    "serialize and load again to JSON as you'd expect" in new Context {
      val inv = PlainArtifactsOrigins(
        List(
          ArtifactOrigin(artifactName="Some_Artifact_id", artifactSource="some artifact description"),
          ArtifactOrigin(artifactName="Some_Artifact_id", artifactSource="some artifact description", artifactProperties = Some(Map("someKey" -> "somevalue")))
        )
      )

      val s = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(inv)
      println("Plain Inventory as JSON: "+s)

      val reloaded = jsonMapper.readValue[PlainArtifactsOrigins](s, classOf[PlainArtifactsOrigins])
      reloaded must beEqualTo(inv)
    }
  }

  "it" should {
    "load from JSON (modified from question" in new Context {
      val reloaded = jsonMapper.readValue[PlainArtifactsOrigins](artifactTestDataJson, classOf[PlainArtifactsOrigins])
      reloaded.artifacts.size must beEqualTo (2)
    }
  }
}

trait ArtifactTestData {
  val artifactTestDataJson =
    """
      |{
      |  "artifacts" : [
      |    {
      |      "artifactName" : "Some_id",
      |      "artifactSource" : "some description"
      |    },
      |    {
      |      "artifactName" : "Some_id",
      |      "artifactSource" : "some description",
      |      "artifactProperties" : {
      |        "someKey" : "somevalue"
      |      }
      |    }
      |  ]
      |}
    """.stripMargin
}