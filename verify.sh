#!/bin/bash
mvn verify
lsof -ti:9001 | xargs kill -9
