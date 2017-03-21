/**
 * Want a "nice", complete println of a graph of objects without
 * having to traverse each object by hand? Use the JsonBuilder or
 JsonOutput.
 */
import groovy.json.*

// just some setup stuff
class Person {
    String name
    List<Address> addresses
}

class Address {
    AddressType type
    String line1
    String line2
    String city
    String state
    String postalCode
}

enum AddressType {
    HOME,
    WORK,
    EMERGENCY
}

def person = new Person(
    name: 'john',
    addresses: [
        new Address(
            type: AddressType.HOME,
            line1: '123 Main St',
            city: 'New York',
            state: 'NY',
            postalCode: '11011'
        ),
        new Address(
            type: AddressType.WORK,
            line1: '1234 Back Alley',
            city: 'New York',
            state: 'NY',
            postalCode: '11011'
        )
    ]
)

// the useful code - json builder
println new JsonBuilder(person).toPrettyString()
// -or- JsonOutput
println JsonOutput.prettyPrint(JsonOutput.toJson(person))
