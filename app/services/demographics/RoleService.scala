package services.demographics

import com.outworkers.phantom.dsl.ResultSet
import domain.demographics.Role
import repositories.demographics.RoleRepository

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


trait RoleService extends RoleRepository{

  def save(obj: Role): Future[ResultSet] = {
    for {
      saveGender <- database.roleTable.save(obj)
    } yield saveGender
  }

  def getById(id: String):Future[Option[Role]] = {
    database.roleTable.getRoleById(id)
  }
  def getAll: Future[Seq[Role]] = {
    database.roleTable.getRoles
  }

}

object RoleService extends RoleService with RoleRepository