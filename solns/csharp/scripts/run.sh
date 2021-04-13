#!/bin/sh
set -e

CORE_VERSION=5.0.5
SDK_VERSION=5.0.202

# There is no csc binary in .NET 5.
# See https://www.jenx.si/2020/10/03/using-roslyn-c-compiler-in-net-5/
dotnet /usr/share/dotnet/sdk/${SDK_VERSION}/Roslyn/bincore/csc.dll \
    -r:/usr/share/dotnet/shared/Microsoft.NETCore.App/${CORE_VERSION}/System.Console.dll \
    -r:/usr/share/dotnet/shared/Microsoft.NETCore.App/${CORE_VERSION}/System.Diagnostics.TraceSource.dll \
    -r:/usr/share/dotnet/shared/Microsoft.NETCore.App/${CORE_VERSION}/System.Linq.dll \
    -r:/usr/share/dotnet/shared/Microsoft.NETCore.App/${CORE_VERSION}/System.Private.CoreLib.dll \
    -r:/usr/share/dotnet/shared/Microsoft.NETCore.App/${CORE_VERSION}/System.Runtime.dll \
    -d:TRACE \
    -out:/tmp/ProjectEuler.Main.dll \
    $@
cd /tmp
cp /scripts/ProjectEuler.Main.runtimeconfig.json .
dotnet ProjectEuler.Main.dll
rm ProjectEuler.Main.dll
rm ProjectEuler.Main.runtimeconfig.json

