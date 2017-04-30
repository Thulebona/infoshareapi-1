package services.location

import com.outworkers.phantom.dsl.ResultSet
import domain.location.LocationType
import repositories.location.LocationTypeRepository

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


trait LocationTypeService extends LocationTypeRepository{

  def save(obj: LocationType): Future[ResultSet] = {
    for {
      locEntity <- database.locationTypeTable.save(obj)
    } yield locEntity
  }

  def getLocById(id: String):Future[Option[LocationType]] = {
    database.locationTypeTable.findById(id)
  }
  def getAllLocactions: Future[Seq[LocationType]] = {
    database.locationTypeTable.findAll
  }

  def deleteById(id:String): Future[ResultSet] = {
    database.locationTypeTable.deleteById(id)
  }

}

object LocationTypeService extends LocationTypeService with LocationTypeRepository