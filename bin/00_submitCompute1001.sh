#!/usr/bin/env bash
export PATH=$PATH:/bigf/admin/flink/flink/bin/
flink run -c com.spdb.streaming.compute.StatRuleComputeMain lib/streaming-compute-1.1.jar --confPath conf/ComputeRule1001.yaml --scenarioId 1001
