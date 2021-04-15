# Project Euler Solutions

## Description

These are solutions to [Project Euler](https://projecteuler.net/) problems.
It's easy to find solutions on the net, so if you don't want to spoil the fun,
don't look at these.

The solutions are organized by language; you'll have to download a Docker image
to run the solutions in a container.  Most languages have official images, but
some do not.  For those that do not, I have published Docker images for them.

Feel free to do WHATEVER with the code; I've added a license so anybody can go
wild with it.

## Usage
### Install Docker

First you'll need Docker to run the solutions so that you run them against the
same version of the language runtimes that I used.

For most platforms, you can just install Docker as per
[instructions](https://docs.docker.com/engine/install/) published on the site.

### Install WSL (Optional)

If you are using Windows, you'll need to install [WSL](https://docs.microsoft.com/en-us/windows/wsl/install-win10)
because `make` is required.  You'll probably want WSL2 but you can read about the
[differences here](https://docs.microsoft.com/en-us/windows/wsl/compare-versions).
For the Linux distribution, you can use whatever you want, but I used Debian.

#### WSL1

With WSL1, you'll need to install Docker Desktop and the `docker` package in your WSL distribution.  Afterwards, you'll need to follow these [instructions](https://nickjanetakis.com/blog/setting-up-docker-for-windows-and-wsl-to-work-flawlessly).

#### WSL2

With WSL2 the process is simpler, you'll need to install Docker Desktop and the Docker CLI.  For Debian, follow the [instructions](https://docs.docker.com/engine/install/debian/), but you only need to install the `docker-ce-cli` package.

### Generate Primes

Some problems require a pre-computed list of primes.  To generate them and place
the data in `/data` (along with other problem specific data sets), run the
following command from the project root directory:

    make primes

### Run Solutions

Each language directory has a `Makefile` run `make ${PROBLEM}` (where
`${PROBLEM}` is a number) to compute the solution for that problem.
For example, to compute the solution for problem number 188 in Racket, do this:

    cd solns/racket
    make 188

### Run Tests

Racket solutions have commonly reused code/libraries.  Run the tests for them
by running the following command from the root directory:

    make test

