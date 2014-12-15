package models

case class Tenant(tenantId: Long, tenantDisplayName:String)
object Tenant{
  var tenants: List[Tenant] = Nil
  def all(): List[Tenant] = tenants
  def create(label: String) {
    tenants = List(Tenant(2,label)):::tenants
  }
  def delete(tenantId: Long) {}
}
