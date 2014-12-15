package models

case class Task(id: Long, label:String)
object Task{
  var tasks: List[Task] = Nil
  def all(): List[Task] = tasks
  def create(label: String) {
    tasks = List(Task(2,label)):::tasks
  }
  def delete(id: Long) {}
}
