package com.utils.scalic

import com.types.scalic.{ Engine, EngineDoesNotExistException }
import com.engines.scalic.RedThreeMPThreeEngine
import com.typesafe.scalalogging.Logger

object EngineFuncs {

    def getEngines(): Map[String,Engine]  = {
        val enginemap = Map ("red3mp3" -> new RedThreeMPThreeEngine)
        return enginemap
    }

    def getEngineByName(name: String): Engine = {
        val lowered: String = name.toLowerCase()
        val engineMap: Map[String, Engine] = getEngines()
        val engine: Option[Engine] = engineMap.get(lowered)
        engine match {
            case Some(s) => s
            case None => throw EngineDoesNotExistException(s"${lowered} engine does not exist")
        }
    }

}

// Logging object
class ScalicLog(verbose: Boolean) {
   val logger = Logger("SCALIC.LOGGER")

    def log(level: String, message: String): Unit = {
        if(verbose==true){
            level match {
                case "DEBUG" => logger.debug(message)
                case "INFO" => logger.info(message)
                case "WARN" => logger.warn(message)
                case "ERROR" => logger.error(message)
                case _ => }
        } else {
            level match {
                case "INFO" => logger.info(message)
                case "ERROR" => logger.error(message)
                case _ =>
            }
        }
    }
}