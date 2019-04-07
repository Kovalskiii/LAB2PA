package com.example.lab2_pa.AUTO;

    public class Automobil extends VehicleType
    {
        

        @Override
        public String getEngineType()
        {
            return "petrol";
        }

        @Override
        public int getFuelTank()
        {
            return 60;
        }

        @Override
        public int getFuelLevel()
        {
            return 30;
        }

        @Override
        public float getEngineCapacity()
        {
            return (float) 4.2;
        }

        @Override
        public int getWheelNumber()
        {
            return 4;
        }

    }


