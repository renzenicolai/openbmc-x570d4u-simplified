SUMMARY = "Python library for displaying tabular data in a ASCII table format"
HOMEPAGE = "http://code.google.com/p/prettytable"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=c9a6829fcd174d9535b46211917c7671"

SRC_URI[sha256sum] = "118eb54fd2794049b810893653b20952349df6d3bc1764e7facd8a18064fa9b0"

do_install:append() {
    perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "*.txt" -o -name "PKG-INFO"`
    for f in $perm_files; do
        chmod 644 "${f}"
    done
}

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/PrettyTable/"
UPSTREAM_CHECK_REGEX = "/PrettyTable/(?P<pver>(\d+[\.\-_]*)+)"

BBCLASSEXTEND = "native nativesdk"
inherit pypi ptest setuptools3

SRC_URI += " \
	file://run-ptest \
"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS:${PN} += " \
	${PYTHON_PN}-math \
	${PYTHON_PN}-html \
	${PYTHON_PN}-wcwidth \
	${PYTHON_PN}-json \
	${PYTHON_PN}-compression \
	${PYTHON_PN}-importlib-metadata \
"

RDEPENDS:${PN}-ptest += " \
    ${PYTHON_PN}-pytest \
    ${PYTHON_PN}-pytest-lazy-fixture \
    ${PYTHON_PN}-sqlite3 \
"

do_install_ptest() {
	cp -f ${S}/tests/test_prettytable.py ${D}${PTEST_PATH}/
}
