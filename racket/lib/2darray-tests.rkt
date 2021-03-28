#lang racket
(provide 2darray-tests)
(require rackunit)
(require "2darray.rkt")


(define 2darray-tests
  (test-suite
    "Tests for 2darray.rkt"

    (test-case
      "create 2darray and set values"
      (let ((m (make-2darray 4 4)))
        (2darray-set! m 0 0 100)
        (2darray-set! m 1 1 100)
        (2darray-set! m 2 2 100)
        (2darray-set! m 3 3 100)
        (check-equal? (2darray-ref m 0 0) 100)
        (check-equal? (2darray-ref m 1 1) 100)
        (check-equal? (2darray-ref m 2 2) 100)
        (check-equal? (2darray-ref m 3 3) 100)))

    (test-case
      "2darray in bounds"
      (let ((m (make-2darray 4 4)))
        (check-true (2darray-in-bounds? m 0 0))
        (check-true (2darray-in-bounds? m 1 1))
        (check-true (2darray-in-bounds? m 2 2))
        (check-true (2darray-in-bounds? m 3 3))
        (check-false (2darray-in-bounds? m 0 4))
        (check-false (2darray-in-bounds? m 1 4))
        (check-false (2darray-in-bounds? m 2 4))
        (check-false (2darray-in-bounds? m 3 4))
        (check-false (2darray-in-bounds? m 0 5))
        (check-false (2darray-in-bounds? m 5 0))))

    (test-case
      "2darray number of rows and columns"
      (let ((m (make-2darray 1 4))
            (n (make-2darray 4 1)))
        (check-equal? (2darray-num-rows m) 1)
        (check-equal? (2darray-num-cols m) 4)
        (check-equal? (2darray-num-rows n) 4)
        (check-equal? (2darray-num-cols n) 1)))

    (test-case
      "2darray row ref"
      (let ((m (make-2darray 4 4)))
        (2darray-set! m 0 0 100)
        (2darray-set! m 1 1 100)
        (2darray-set! m 2 2 100)
        (2darray-set! m 3 3 100)
        (check-equal? (2darray-row-ref m 0) (vector 100 0 0 0))
        (check-equal? (2darray-row-ref m 1) (vector 0 100 0 0))
        (check-equal? (2darray-row-ref m 2) (vector 0 0 100 0))
        (check-equal? (2darray-row-ref m 3) (vector 0 0 0 100))))))
