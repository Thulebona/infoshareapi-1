package api.storage

import domain.storage.StorageUrl
import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

class StorageUrlCtrlTest extends FunSuite with BeforeAndAfter with GuiceOneAppPerTest {

  var entity, updateEntity : StorageUrl = _
  var baseUrl = "/storage/storageurl/"
  val title = "storage url"

  before {
    entity = StorageUrl(id = "1", name = "my profile", url = "http://cput.ac.za/logo.jpeg")
  }

  test("Create "+title){
    val request = route(app, FakeRequest(POST, baseUrl + "create")
      .withJsonBody(Json.toJson(entity))
      .withHeaders(AUTHORIZATION -> "Token")
    ).get

    assert(status(request) equals OK)
    assert(contentAsString(request) equals Json.toJson(entity).toString() )
  }

  test("update "+title){
    updateEntity = entity.copy(name="cput logo")
    val request = route(app, FakeRequest(POST, baseUrl+"create")
      .withJsonBody(Json.toJson(updateEntity))
      .withHeaders(AUTHORIZATION -> "Token")
    ).get
    assert(status(request) equals OK)
    assert(contentAsString(request) != Json.toJson(entity).toString())
    assert(contentAsString(request) equals Json.toJson(updateEntity).toString())
  }

  test("get "+title+" by id"){
    val request = route(app, FakeRequest(GET, baseUrl+entity.id)
      .withHeaders(AUTHORIZATION -> "Token")
    ).get
    assert(status(request) equals OK)
    assert(contentAsString(request) equals Json.toJson(updateEntity).toString())
  }

  test("get all "+title){
    val request = route(app, FakeRequest(GET, baseUrl+"all")
      .withHeaders(AUTHORIZATION -> "Token")
    ).get
    assert(status(request) equals OK)
  }

}
