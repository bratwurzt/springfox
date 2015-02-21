package com.mangofactory.service.model
import com.mangofactory.documentation.builders.ResponseMessageBuilder
import com.mangofactory.documentation.schema.ModelRef
import spock.lang.Specification

class ResponseMessageSpec extends Specification {
  def "ResponseMessage equals only takes the code into account" () {
    given:
      def sut = responseMessage(200, "message", "String")
    expect:
      sut.equals(test) == expectedEquality
      sut.equals(sut)
    where:
      test                                        | expectedEquality
      responseMessage(200, "message", "String")   | true
      responseMessage(200, "", "String")          | true
      responseMessage(200, "message", "")         | true
      responseMessage(201, "message", "string")   | false
  }

  def responseMessage(code, message, responseModel) {
    new ResponseMessageBuilder().code(code)
            .message(message)
            .responseModel(new ModelRef(responseModel)).build()
  }
}
