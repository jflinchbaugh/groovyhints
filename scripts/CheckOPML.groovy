#!/usr/bin/env groovy

import groovyx.gpars.*

// open an OPML file and print out a readable text rendering of it

def opml = new XmlSlurper().parse("BeyondPodFeeds.opml")
println opml.body.outline.findAll {
    it.outline.size()
}.each { cat ->
    println cat.@text
    GParsPool.withPool {
        cat.outline.collectParallel { feed ->
            println "starting"
            def up = false
            try {
                up = new URL(feed.@xmlUrl as String).text as Boolean
            } catch(Exception ex) {
            }
            "  ${feed.@text} - ${feed.@xmlUrl} (${up})"
        }.each(this.&println)
    }
}
