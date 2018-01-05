package com.github.sguzman.scala.js.binding.spinner

import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div
import org.scalajs.dom.{Event, document}

object Main {
  @dom def spinner(count: Var[Int]): Binding[Div] = {
    <div>
      <button onclick={e: Event => println("Clicked on decr button")}>-</button>
      {count.bind.toString}
      <button onclick={e: Event => println("Clicked on incr button")}>+</button>
    </div>
  }

  def main(args: Array[String]): Unit = {
    dom.render(document.body, spinner(Var(0)))
  }
}
