/**
 * This is an extension script to boot up Geb and a browser
 * to facilitate interactively exploring a page with Geb.
 * It will likely require a webdriver for your browser:
 * Geckodriver for firefox: https://github.com/mozilla/geckodriver/releases
 *
 * % groovysh gebsh.groovy
 */
import groovy.grape.Grape

Grape.grab(group: 'org.gebish', module: 'geb-core', version: '1.1.1')
Grape.grab(
    group: 'org.seleniumhq.selenium',
    module: 'selenium-firefox-driver',
    version: '3.3.1'
)
/*
Grape.grab(
    group: 'org.seleniumhq.selenium',
    module: 'htmlunit-driver',
    version: '2.25'
)
*/

import geb.*
import org.openqa.selenium.*

b = new Browser()

println '''
Welcome!
Example Usage (b is your browser):
  groovy:000> b.go 'http://google.com'
  groovy:000> println b.$('a')*.@href
  groovy:000> b.$('a')[0].click()
  groovy:000> println b.title
  groovy:000> println b.currentUrl
  groovy:000> println b.page.title
  groovy:000> b.driver.navigate().back()
  groovy:000> println b.q
'''
