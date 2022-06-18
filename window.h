#pragma once
#include <QPoint>
#include <QWidget>
#include <QLineEdit>
#include <QTableWidget>

class Window : public QWidget
{
	Q_OBJECT

public:
	Window(QWidget *parent = 0);

private slots:
	void contextMenu(const QPoint &pos);	

private:
	void createTableWidget();

	QLineEdit *lineEdit;
	QTableWidget *tableWidget;
};