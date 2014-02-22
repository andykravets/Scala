/**
 * Created by Andrew Kravets on 2/22/14.
 */
object TimerAnonymous {
  def oncePerSecond(callback:()=>Unit){
    while (true){
      callback()
      Thread sleep(1000)
    }
  }

  def main(args: Array[String]){
    oncePerSecond(()=> println("time flies like an arrow..."))
  }

}
