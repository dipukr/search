#include <QAbstractItemView>
#include <QVBoxLayout>
#include <QHeaderView>
#include <QMenu>
#include <QAction>
#include "window.h"

Window::Window(QWidget *parent) : QWidget(parent)
{
	createTableWidget();
	lineEdit = new QLineEdit();
	QVBoxLayout *layout = new QVBoxLayout();
	layout->addWidget(lineEdit);
	layout->addWidget(tableWidget);
	layout->addSpacing(20);
	layout->setContentsMargins(0,0,0,0);
	lineEdit->setMaxLength(100);
	setLayout(layout);
}

void Window::createTableWidget()
{
	tableWidget = new QTableWidget(0, 2);
	QStringList labels;
	labels << "Name" << "Path";
	tableWidget->setShowGrid(false);
	tableWidget->verticalHeader()->hide();
	tableWidget->setHorizontalHeaderLabels(labels);
	tableWidget->setSelectionBehavior(QAbstractItemView::SelectRows);
	QHeaderView *header = tableWidget->horizontalHeader();
	tableWidget->setColumnWidth(0, 250);
	header->setStretchLastSection(true);
	tableWidget->setContextMenuPolicy(Qt::CustomContextMenu);
	connect(tableWidget, &QTableWidget::customContextMenuRequested, this, &Window::contextMenu);
}

void Window::contextMenu(const QPoint &pos)
{
	QMenu menu;
	QAction *openAction = menu.addAction("Open");
	QAction *fileAction = menu.addAction("Open file location");
	QAction *action = menu.exec(tableWidget->mapToGlobal(pos));
}