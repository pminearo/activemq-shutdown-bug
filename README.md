activemq-shutdown-bug
=====================

Project to test the bug with shutting down an embedded ActiveMQ.

This project will start up 2 Brokers in separate Spring configs creating a JMS Queue between them.  Then it will try to shutdown the Broker that is creating the Bridge.  The connection between the 2 bridges will not stop, so the Thread hangs and does not allow the second Broker to stop.
