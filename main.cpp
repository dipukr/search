#include <QApplication>
#include "mainwindow.h"
#include "window.h"

int main(int argc, char **argv)
{
	QApplication app(argc, argv);
	app.setStyleSheet("QLineEdit{height: 20px;}");
	MainWindow window;
	window.show();
	return app.exec();
}