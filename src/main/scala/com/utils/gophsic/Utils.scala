package com.utils.gophsic

import com.types.gophsic.{ Engine, EngineDoesNotExistException }
import com.engines.gophsic.RedThreeMPThreeEngine

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