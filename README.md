# Project Euler Solutions

## Description

These are solutions to [Project Euler](https://projecteuler.net/) problems.  It's easy to find solutions on the net, so if you don't want to spoil the fun, don't look at these.

The [solutions](http://retiman.github.io/project-euler/) are organized by language; you'll have to download a Docker image to run the solutions in a container.  Most languages have official images, but some do not.  For those that do not, I have published Docker images for them.

Feel free to do WHATEVER with the code; I've added a license so anybody can go wild with it.

## Usage

1. Install [Docker](https://docs.docker.com/engine/install/).
1. Install [make](https://www.gnu.org/software/make/manual/make.html).
1. Generate prime numbers to use for some problems by running `make primes`.
1. Run any solution from a `solns` directory via `make <problem number>`.
1. Optionally install [VSCode](https://code.visualstudio.com/) to run problems in a devcontainer](https://code.visualstudio.com/docs/remote/containers) or to run language specific lints.
1. Optionally run `make test` from the `solns/racket` directory.
1. Optionally check out solution explanations on [http://retiman.github.io/project-euler/](http://retiman.github.io/project-euler/) published from the `docs` directory.

The `Makefile` in each solution directory will download the appropriate Docker image if you don't have it already.  None of the `Makefile`s assume that you are running on Windows/Linux/MacOS.
