package com.types.scalic

import io.lemonlabs.uri.Url
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.model.Document
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model._


abstract class Engine(
    var Name: String,
    var BaseURL: Url,
    var SearchURL: Url
) {

    override def toString(): String = {
        s"${Name} Engine at ${BaseURL}"
    }
    val browser = new JsoupBrowser("Mozilla")

    def getAttributes(): List[String]

    // Parse a single music element, 
    // called by parseSoup
    def parseSingleMovie(ind: Int, elem: Element): Music
    
    // Parse the entire soup and return tags
    // for the necessary music elements
    def search(query: String): List[Music]
}

case class EngineDoesNotExistException(message: String) extends Exception
