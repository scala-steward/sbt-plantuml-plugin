//Customized release
import sbtrelease.ReleaseStateTransformations._

name := "sbt-plantuml-plugin"

organization := "io.metabookmarks"

enablePlugins(SbtPlugin)

scalaVersion := "2.12.12"

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "1.2021.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % Test

scalafmtOnCompile := true

publishMavenStyle := false

githubOwner := "metabookmarks"

githubRepository := "sbt-plantuml-plugin"

scalacOptions in console += "-Ywarn-unused-import"

crossSbtVersions := Vector("1.4.4", "0.13.18")

releaseCrossBuild := true

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  releaseStepCommandAndRemaining("^ test"),
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("^ publish"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
