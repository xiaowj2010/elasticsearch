/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.aggregations.pipeline;

import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.search.DocValueFormat;
import org.elasticsearch.search.aggregations.InternalAggregation;
import org.elasticsearch.search.aggregations.metrics.InternalStats;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InternalStatsBucket extends InternalStats implements StatsBucket {
    public InternalStatsBucket(String name, long count, double sum, double min, double max, DocValueFormat formatter,
                               List<PipelineAggregator> pipelineAggregators, Map<String, Object> metaData) {
        super(name, count, sum, min, max, formatter, pipelineAggregators, metaData);
    }

    /**
     * Read from a stream.
     */
    public InternalStatsBucket(StreamInput in) throws IOException {
        super(in);
    }

    @Override
    public String getWriteableName() {
        return StatsBucketPipelineAggregationBuilder.NAME;
    }

    @Override
    public InternalStats doReduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        throw new UnsupportedOperationException("Not supported");
    }
}
