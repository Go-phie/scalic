package com.types.gophsic

import io.lemonlabs.uri.Url
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

abstract class Engine(
    var Name: String,
    var BaseURL: Url,
    var SearchURL: Url
) {

    override def toString(): String = {
        s"${Name} Engine at ${BaseURL}"
    }
    
    val browser = JsoupBrowser()

    def getAttributes(): List[String]

    // Parse a single music element, 
    // called by parseSoup
    def parseSingleMovie(elem: Element): Music
    
    // Parse the entire soup and return tags
    // for the necessary music elements
    def search(query: String) {
        val subMap = Map ("str" -> query)
        val doc2 = browser.post(SearchURL.toString, subMap)
    }
}

case class EngineDoesNotExistException(message: String) extends Exception
