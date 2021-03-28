# Description

These are solutions to (Project Euler)[https://projecteuler.net/] problems.
It's easy to find solutions on the net, so if you don't want to spoil the fun,
don't look at these.

The solutions are organized by language; you'll have to download a Docker image
to run the solutions in a container.  Most languages have official images, but
some do not.  For those that do not, I have published Docker images for them.

Feel free to do WHATEVER with the code; I've added a license so anybody can go
wild with it.

# Usage
## Install Docker

First you'll need Docker to run the solutions so that you run them against the
same version of the language runtimes that I used.

For most platforms, you can just install Docker as per
(instructions)[https://docs.docker.com/engine/install/] published on the site.

## Install WSL (Optional)

If you are using Windows, you'll need to install (WSL)[https://docs.microsoft.com/en-us/windows/wsl/install-win10]
because make is required.  You'll probably want WSL2 but you can read about the
(differences here)[https://docs.microsoft.com/en-us/windows/wsl/compare-versions].
For the Linux distribution, you can use whatever you want, but I used Debian.

### WSL1

With WSL1, you'll need both Docker Desktop and the `docker` CLI, and you need to
follow these (instructions)[https://nickjanetakis.com/blog/setting-up-docker-for-windows-and-wsl-to-work-flawlessly].

### WSL2

With WSL2, things are simpler as you only need the `docker` CLI.  For Debian,
follow the (instructions)[https://docs.docker.com/engine/install/debian/], but
you only need to install the `docker-ce-cli` package.

## Generate Primes

Some problems require a pre-computed list of primes.  Run `make primes` from
the project root directory to generate them.  They will be placed in the `data`
directory, where some problem specific data may reside.

The primes generation script is written in Racket; most solutions and scripts
are written in Racket here.

## Run Solutions

Each language directory has a `Makefile` run `make ${PROBLEM}` (where
`${PROBLEM}` is a number) to compute the solution for that problem.
For example, to compute the solution for problem number 1 in Racket, do this:

    cd racket
    make 1

## Run Tests

Racket solutions have commonly reused code/libraries.  Run the tests for them
by running `make test` from the root directory.
