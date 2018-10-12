# Firebase Performance Monitoring bug

Sample app to reproduce a bug in the Firebase Performance Monitoring library.


- Error: `SHA-256 digest error for META-INF/maven/at.favre.lib/bcrypt/pom.xml`
- How to reproduce: try to build this project
- Discussion: https://stackoverflow.com/q/52777516/6305235
- Stacktrace:

```
org.gradle.api.tasks.TaskExecutionException: Execution failed for task ':app:transformClassesWithFirebasePerformancePluginFor[Flavour]'.
    at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeActions(ExecuteActionsTaskExecuter.java:110)
    at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:77)
    at org.gradle.api.internal.tasks.execution.OutputDirectoryCreatingTaskExecuter.execute(OutputDirectoryCreatingTaskExecuter.java:51)
    at org.gradle.api.internal.tasks.execution.SkipUpToDateTaskExecuter.execute(SkipUpToDateTaskExecuter.java:59)
    at org.gradle.api.internal.tasks.execution.ResolveTaskOutputCachingStateExecuter.execute(ResolveTaskOutputCachingStateExecuter.java:54)
    at org.gradle.api.internal.tasks.execution.ValidatingTaskExecuter.execute(ValidatingTaskExecuter.java:59)
    at org.gradle.api.internal.tasks.execution.SkipEmptySourceFilesTaskExecuter.execute(SkipEmptySourceFilesTaskExecuter.java:101)
    at org.gradle.api.internal.tasks.execution.FinalizeInputFilePropertiesTaskExecuter.execute(FinalizeInputFilePropertiesTaskExecuter.java:44)
    at org.gradle.api.internal.tasks.execution.CleanupStaleOutputsExecuter.execute(CleanupStaleOutputsExecuter.java:91)
    at org.gradle.api.internal.tasks.execution.ResolveTaskArtifactStateTaskExecuter.execute(ResolveTaskArtifactStateTaskExecuter.java:62)
    at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:59)
    at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:54)
    at org.gradle.api.internal.tasks.execution.ExecuteAtMostOnceTaskExecuter.execute(ExecuteAtMostOnceTaskExecuter.java:43)
    at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:34)
    at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.run(EventFiringTaskExecuter.java:51)
    at org.gradle.internal.operations.DefaultBuildOperationExecutor$RunnableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:300)
    at org.gradle.internal.operations.DefaultBuildOperationExecutor$RunnableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:292)
    at org.gradle.internal.operations.DefaultBuildOperationExecutor.execute(DefaultBuildOperationExecutor.java:174)
    at org.gradle.internal.operations.DefaultBuildOperationExecutor.run(DefaultBuildOperationExecutor.java:90)
    at org.gradle.internal.operations.DelegatingBuildOperationExecutor.run(DelegatingBuildOperationExecutor.java:31)
    at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:46)
    at org.gradle.execution.taskgraph.LocalTaskInfoExecutor.execute(LocalTaskInfoExecutor.java:42)
    at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareWorkItemExecutor.execute(DefaultTaskExecutionGraph.java:277)
    at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareWorkItemExecutor.execute(DefaultTaskExecutionGraph.java:262)
    at org.gradle.execution.taskgraph.DefaultTaskPlanExecutor$ExecutorWorker$1.execute(DefaultTaskPlanExecutor.java:135)
    at org.gradle.execution.taskgraph.DefaultTaskPlanExecutor$ExecutorWorker$1.execute(DefaultTaskPlanExecutor.java:130)
    at org.gradle.execution.taskgraph.DefaultTaskPlanExecutor$ExecutorWorker.execute(DefaultTaskPlanExecutor.java:200)
    at org.gradle.execution.taskgraph.DefaultTaskPlanExecutor$ExecutorWorker.executeWithWork(DefaultTaskPlanExecutor.java:191)
    at org.gradle.execution.taskgraph.DefaultTaskPlanExecutor$ExecutorWorker.run(DefaultTaskPlanExecutor.java:130)
    at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:63)
    at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:46)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
    at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:55)
    at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.SecurityException: SHA-256 digest error for META-INF/maven/at.favre.lib/bcrypt/pom.xml
    at sun.security.util.ManifestEntryVerifier.verify(ManifestEntryVerifier.java:218)
    at java.util.jar.JarVerifier.processEntry(JarVerifier.java:241)
    at java.util.jar.JarVerifier.update(JarVerifier.java:228)
    at java.util.jar.JarInputStream.read(JarInputStream.java:212)
    at com.google.common.io.ByteStreams.toByteArrayInternal(ByteStreams.java:181)
    at com.google.common.io.ByteStreams.toByteArray(ByteStreams.java:221)
    at com.google.firebase.perf.plugin.instrumentation.Instrument.instrumentClassesInJar(Instrument.java:105)
    at com.google.firebase.perf.plugin.FirebaseTransform.transformJarInputs(FirebaseTransform.java:230)
    at com.google.firebase.perf.plugin.FirebaseTransform.transform(FirebaseTransform.java:192)
    at com.android.build.gradle.internal.pipeline.TransformTask$2.call(TransformTask.java:239)
    at com.android.build.gradle.internal.pipeline.TransformTask$2.call(TransformTask.java:235)
    at com.android.builder.profile.ThreadRecorder.record(ThreadRecorder.java:102)
    at com.android.build.gradle.internal.pipeline.TransformTask.transform(TransformTask.java:230)
    at sun.reflect.GeneratedMethodAccessor899.invoke(Unknown Source)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.gradle.internal.reflect.JavaMethod.invoke(JavaMethod.java:73)
    at org.gradle.api.internal.project.taskfactory.IncrementalTaskAction.doExecute(IncrementalTaskAction.java:50)
    at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:39)
    at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:26)
    at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter$1.run(ExecuteActionsTaskExecuter.java:131)
    at org.gradle.internal.operations.DefaultBuildOperationExecutor$RunnableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:300)
    at org.gradle.internal.operations.DefaultBuildOperationExecutor$RunnableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:292)
    at org.gradle.internal.operations.DefaultBuildOperationExecutor.execute(DefaultBuildOperationExecutor.java:174)
    at org.gradle.internal.operations.DefaultBuildOperationExecutor.run(DefaultBuildOperationExecutor.java:90)
    at org.gradle.internal.operations.DelegatingBuildOperationExecutor.run(DelegatingBuildOperationExecutor.java:31)
    at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeAction(ExecuteActionsTaskExecuter.java:120)
    at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeActions(ExecuteActionsTaskExecuter.java:99)
    ... 34 more
```
