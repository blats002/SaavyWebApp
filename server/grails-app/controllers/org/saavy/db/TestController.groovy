package org.saavy.db

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class TestController {

    TestService testService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond testService.list(params), model:[testCount: testService.count()]
    }

    //pagination friendly
//    def index(Integer max, Integer offset) {
//        params.max = Math.min(max ?: 10, 100)
//        params.offset = offset ?: 0
//
//        def results = testService.list(params)
//        def totalCount = testService.count()
//
//        respond results, model: [
//                testCount: totalCount,
//                currentPage: (offset / params.max) + 1
//        ]
//    }

    def show(Long id) {
        respond testService.get(id)
    }

    @Transactional
    def save(Test test) {
        if (test == null) {
            render status: NOT_FOUND
            return
        }
        if (test.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond test.errors
            return
        }

        try {
            testService.save(test)
        } catch (ValidationException e) {
            respond test.errors
            return
        }

        respond test, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Test test) {
        if (test == null) {
            render status: NOT_FOUND
            return
        }
        if (test.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond test.errors
            return
        }

        try {
            testService.save(test)
        } catch (ValidationException e) {
            respond test.errors
            return
        }

        respond test, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || testService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
