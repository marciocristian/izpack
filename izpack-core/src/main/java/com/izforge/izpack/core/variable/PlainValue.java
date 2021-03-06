/*
 * IzPack - Copyright 2001-2010 Julien Ponge, All Rights Reserved.
 *
 * http://izpack.org/
 * http://izpack.codehaus.org/
 *
 * Copyright 2010 Rene Krell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.izforge.izpack.core.variable;

import com.izforge.izpack.api.substitutor.VariableSubstitutor;

import java.io.Serializable;
import java.util.Set;


public class PlainValue extends ValueImpl implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -8081979859867523421L;

    public String value; // mandatory

    public PlainValue(String value)
    {
        super();
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public void validate() throws Exception
    {
        if (this.value == null)
        {
            throw new Exception("Unset plain value");
        }
    }

    @Override
    public String resolve()
    {
        return value;
    }

    @Override
    public String resolve(VariableSubstitutor... substitutors) throws Exception
    {
        String _value_ = value;
        for (VariableSubstitutor substitutor : substitutors)
        {
            _value_ = substitutor.substitute(_value_);
        }

        return _value_;
    }

    @Override
    public Set<String> getVarRefs()
    {
        return parseUnresolvedVariableNames(value);
    }
}
