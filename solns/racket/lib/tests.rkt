#lang racket


(require rackunit/text-ui)
(require "2darray-tests.rkt")
(require "core-tests.rkt")
(require "number-theory-tests.rkt")
(require "set-tests.rkt")
(require "string-tests.rkt")

(displayln "2darray-tests")
(run-tests 2darray-tests)
(displayln "core-tests")
(run-tests core-tests)
(displayln "number-theory-tests")
(run-tests number-theory-tests)
(displayln "set-tests")
(run-tests set-tests)
(displayln "string-tests")
(run-tests string-tests)
