ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaPractical",
    idePackagePrefix := Some("org.scala.practical")
  )

libraryDependencies+="com.lihaoyi" %% "os-lib" % "0.8.1"
