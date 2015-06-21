Summary: HelloWorld
Name: helloworld
Version: 1
Release: %{?BUILD_NUMBER}
License: Restricted
Group: Applications/System
BuildRoot: %{_builddir}/%{name}-%{version}-%{release}-root
URL: http://www.icsinc.com
Vendor: ICS, Inc.
Packager: Benjamin Willett
Prefix: /var/www/html
BuildArchitectures: noarch
%description
Website

%prep
%build
%install
rm -rf $RPM_BUILD_ROOT
mkdir -p $RPM_BUILD_ROOT/var/lib/tomcat6/webapps/HelloWorld
cd $RPM_BUILD_ROOT/var/lib/tomcat6/webapps/HelloWorld
tar -xf $RPM_BUILD_DIR/HelloWorld.tar
%clean
rm -rf $RPM_BUILD_ROOT 
rm -rf $RPM_BUILD_DIR
%files
%defattr(644, root, tomcat, 755)
/var/lib/tomcat6/webapps/*
%changelog
*Tue Mar 30 2014 Willett
*Created initial spec file for helloworld