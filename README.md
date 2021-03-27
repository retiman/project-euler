DESCRIPTION
===========

These are solutions to Project Euler problems.  It's easy to find solutions on
the net, so if you don't want to spoil the fun, don't look at these.

Feel free to do WHATEVER with the code; I've added a license so anybody can go
wild with it.

USAGE
=====
Check which solutions have been provided by running:

    make stats

Some problems require a pre-computed list of primes.  You can download the
list by running:

    make primes

The default limit for primes is 10^8 but some problems do not require so many
primes to be pre-computed.

Run particular solutions by descending into a language's subdirectory and
running `make` For example, to run the solution for problem #25 in Racket, do
this:

    cd racket
    make 25

LANGUAGES
=========
Racket is my preferred language and will have more problems solved in that
language than any other. Racket is the only language that will consistently
have explanations in source about what is happening.

* Clojure: Clojure 1.3.0
* Golang: go1.11.6
* Lua: 5.2.2
* Racket: Racket 6.2
* Scala: Scala 2.11.12
