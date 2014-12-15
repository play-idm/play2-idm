package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{Tenant}
import com.sun.xml.internal.bind.v2.TODO

object Application extends Controller {
  val tenantForm = Form(
    "label" -> nonEmptyText
  )
  def index = Action {
    Redirect(routes.Application.tenants)
  }
  def tenants = Action {
    Ok(views.html.index(Tenant.all(), tenantForm))
  }
  def newTenant = Action {
    implicit request =>
      tenantForm.bindFromRequest.fold(
        errors => BadRequest(views.html.index(Tenant.all(),errors)),
        label => {
          Tenant.create(label)
          Redirect(routes.Application.tenants)
        }
      )
  }
  def deleteTenant(id: Long) = Action { implicit request =>
    Tenant.delete(id)
    Redirect(routes.Application.tenants)
  }
}
