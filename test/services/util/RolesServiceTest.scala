package services.util
import domain.util.Roles
import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by hashcode on 2017/04/22.
  */
class RolesServiceTest extends FunSuite{

  val entity = Roles("1","USER")
  val updatedEntity = entity.copy(rolename = "ADMIN")
  val service = RolesService

  test("Create Role Status"){
    val result = Await.result(service.save(entity),2 minutes)
    assert(result.isExhausted)
  }

  test{"Read  Role Value "}{
    val result = Await.result(service.getRoleById("1"),2 minutes)
    assert(result.get.rolename=="USER")

  }

  test("Upadte Role"){
    val update = Await.result(service.save(updatedEntity),2 minutes)
    val result = Await.result(service.getRoleById("1"),2 minutes)
    assert(result.get.rolename=="ADMIN")

  }

}