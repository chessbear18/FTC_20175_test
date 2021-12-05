public void mecanumDrive_Cartesian(double x, double y, double rotation)
{
    double wheelSpeeds[] = new double[4];

    wheelSpeeds[0] = x + y + rotation;
    wheelSpeeds[1] = -x + y - rotation;
    wheelSpeeds[2] = -x + y + rotation;
    wheelSpeeds[3] = x + y - rotation;

    normalize(wheelSpeeds);

    leftFrontMotor.setPower(wheelSpeeds[0]);
    rightFrontMotor.setPower(wheelSpeeds[1]);
    leftRearMotor.setPower(wheelSpeeds[2]);
    rightRearMotor.setPower(wheelSpeeds[3]);
}   //mecanumDrive_Cartesian

private void normalize(double[] wheelSpeeds)
{
    double maxMagnitude = Math.abs(wheelSpeeds[0]);

    for (int i = 1; i < wheelSpeeds.length; i++)
    {
        double magnitude = Math.abs(wheelSpeeds[i]);

        if (magnitude > maxMagnitude)
        {
            maxMagnitude = magnitude;
        }
    }

    if (maxMagnitude > 1.0)
    {
        for (int i = 0; i < wheelSpeeds.length; i++)
        {
            wheelSpeeds[i] /= maxMagnitude;
        }
    }
}   //normalize