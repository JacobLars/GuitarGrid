import { Amplifier } from "@/app/types/Types";
import React from "react";
type Props = {
  amplifier: Amplifier;
};
export const AmplifierInfo = ({ amplifier }: Props) => {
  const hasBatteryOperation = amplifier.batteryOperation ? "Yes" : "No";
  const hasReverb = amplifier.reverb ? "Yes" : "No";
  const hasExternalFxLoop = amplifier.externalFxLoop ? "Yes" : "No";
  const hasLineInput = amplifier.lineInput ? "Yes" : "No";
  const hasFootSwitchConnection = amplifier.footSwitchConnection ? "Yes" : "No";
  const hasEffectsProcessor = amplifier.effectsProcessor ? "Yes" : "No";
  const hasMicrophoneInput = amplifier.microphoneInput ? "Yes" : "No";
  return (
    <div className="flex flex-col text-xl items-center md:flex-row md:items-start md:justify-center">
      <ul className="w-3/4 shadow-lg m-2 md:w-1/3 p-5">
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 md:mt-1">Brand:</p>
          <p className="mb-1">{amplifier.brandName}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Weight:</p>
          <p className="mb-1 mt-1">{amplifier.weight} kg</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Power:</p>
          <p className="mb-1 mt-1">{amplifier.power} W</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Channels:</p>
          <p className="mb-1 mt-1">{amplifier.channels}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Microphone Input:</p>
          <p className="mb-1 mt-1">{hasMicrophoneInput}</p>
        </li>
      </ul>
      <ul className="w-3/4 shadow-lg m-2 md:w-1/3 p-5">
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Battery Operation:</p>
          <p className="mb-1 mt-1">{hasBatteryOperation}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Reverb:</p>
          <p className="mb-1 mt-1">{hasReverb}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">External FX loop:</p>
          <p className="mb-1 mt-1">{hasExternalFxLoop}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Line input:</p>
          <p className="mb-1 mt-1">{hasLineInput}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Footswitch connection:</p>
          <p className="mb-1 mt-1">{hasFootSwitchConnection}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Effects Processor:</p>
          <p className="mb-1 mt-1">{hasEffectsProcessor}</p>
        </li>
      </ul>
    </div>
  );
};
