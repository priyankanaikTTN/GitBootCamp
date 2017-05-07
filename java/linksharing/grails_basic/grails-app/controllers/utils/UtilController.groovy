package utils

class UtilController {

    def index() {

        Object ob= new Object()

        log.info("$params")
        log.warn("$params")
        log.debug("$params")
        log.trace("$params")
        log.error("$params")
        //log.fatal(ob)
        render "$params"
    }
}
