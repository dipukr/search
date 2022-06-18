#include <QMenu>
#include <QMenuBar>
#include <QStatusBar>
#include "window.h"
#include "mainwindow.h"

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent)
{
	setFixedSize(720, 480);
	Window *window = new Window(this);
	setCentralWidget(window);
	menuBar()->addMenu(new QMenu("File"));
	QMainWindow::setStatusBar(0);
	//this->statusBar()->hide();
}
