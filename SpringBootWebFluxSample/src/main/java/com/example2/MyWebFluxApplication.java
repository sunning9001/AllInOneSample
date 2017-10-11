/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example2.routing.HelloRouter;
import com.example2.routing.IndexRouter;
import com.example2.routing.PersonRouter;
import com.example2.routing.PostEchoRouter;
import com.example2.routing.StreamRouter;

@SpringBootApplication
public class MyWebFluxApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyWebFluxApplication.class);
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(IndexRouter indexRouter, PostEchoRouter echoRouter, HelloRouter helloRouter, StreamRouter streamRouter, PersonRouter personRouter) {
        return indexRouter.routes().and(helloRouter.routes()).and(echoRouter.routes()).and(streamRouter.routes()).and(streamRouter.routes()).and(personRouter.routes());
    }

}
