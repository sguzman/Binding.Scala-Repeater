package com.github.sguzman.scala.js.binding.spinner

import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.document
import org.scalajs.dom.html.Div
import org.scalajs.dom.raw.MouseEvent

object Main {
  @dom def spinner(count: Var[Int]): Binding[Div] = {
    <div>
      <button onclick={_: MouseEvent => count.value_=(count.value - 1)}>-</button>
      {count.bind.toString}
      <button onclick={_: MouseEvent => count.value_=(count.value + 1)}>+</button>
    </div>
  }

  @dom def render(init: Var[Int]): Binding[Div] = {
    <div>
      {spinner(init).bind}
      <h1>At count {init.bind.toString}</h1>
    </div>
  }

  def main(args: Array[String]): Unit = {
    dom.render(document.body, render(Var(0)))
  }
}
