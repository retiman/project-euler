PYTHON ?= $(if $(shell which python2), python2, python)

%: %.py
	PYTHONPATH=lib time ${PYTHON} $<
